require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "imx53"
KERNEL_DEVICETREE ?= "imx53-embtom.dtb"

LINUX_VERSION = "5.0"
LINUX_VERSION_EXTENSION = "-embtom"

#FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

SRCREV = "064acf371a512e4ab3bc82fd5c8245b370d11afa"


SRC_URI = " \ 
    git://github.com/embtom/linux.git;branch=embtom/imx53Embtom \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
    file://defconfig \
"
