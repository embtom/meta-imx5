require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"
COMPATIBLE_MACHINE = "imx53"

LINUX_VERSION = "5.1"
LINUX_VERSION_EXTENSION = "-embtom"

#FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

SRCREV = "153a3b89c44b913b1e751ff395c8b5b8a938564e"
SRC_URI = " \ 
    git://github.com/embtom/linux.git;branch=embtom/v5.1-imx53-rc \
    file://defconfig \
"
