SUMMARY = "Linux Console Project"
DESCRIPTION = "Linux Console tools, which include utilities to test and configure joysticks, connect legacy devices to the kernel's input subsystem"
HOMPAGE = "https://sourceforge.net/projects/linuxconsole/"
SECTION = "console/tools"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING-1;md5=5b122a36d0f6dc55279a0ebc69f3c60b"

SRC_URI = "git://git.code.sf.net/p/linuxconsole/code;branch=master \      
           file://0001-makefile.patch \
           file://0002-inputattach.patch \
           file://12-touch-inputattach.rules"

# We need the kernel to be staged (unpacked, patched and configured) before
# we can grab the source and make the source package. We also need the bits from
# ${B} not to change while we install, so virtual/kernel must finish do_compile.
do_install[depends] += "virtual/kernel:do_shared_workdir"
# Need the source, not just the output of populate_sysroot
do_install[depends] += "virtual/kernel:do_install"


SRCREV = "release-1.6.0"

S = "${WORKDIR}/git/utils"
A = "${WORKDIR}"

CFLAGS =+ "${LDFLAGS} -I. -I../linux/include -I${STAGING_KERNEL_DIR}/include/uapi"


do_install() {
        install -d ${D}${sbindir}
        install inputattach ${D}${sbindir}
        install -d ${D}/${sysconfdir}/udev/rules.d
        install -m 644 ${A}/12-touch-inputattach.rules ${D}/${sysconfdir}/udev/rules.d
}

FILES_${PN} = "${sbindir}/*" 
FILES_${PN} += "${sysconfdir}/udev"
RDEPENDS_${PN} = "udev"


