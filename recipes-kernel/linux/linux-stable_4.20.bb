require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "imx53"

#KERNEL_DEVICETREE ?= "imx53-ard.dtb"
KERNEL_DEVICETREE ?= "imx53-embtom.dtb"

# KERNEL_DEVICETREE ?= " \
#     am335x-boneblack.dtb \
#     am335x-boneblack-wireless.dtb \
#     am335x-boneblue.dtb \
#     am335x-bonegreen.dtb \
#     am335x-bonegreen-wireless.dtb \
# "

LINUX_VERSION = "4.20"
LINUX_VERSION_EXTENSION = "-embtom"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "4.20.3"
#SRCREV = "57a765e89cc27f9951e687ad92cf21f6ae918663"
SRCREV = "92ff81ae6821cfd37908e66b11e21d2392eac5ac"

#git://git@tomhp.fritz.box/yocto/linux-stable.git;protocol=ssh;branch=linux-${LINUX_VERSION}.y_imx53 

SRC_URI = " \ 
    git://git@tomhp.fritz.box/yocto/linux-stable.git;protocol=ssh;branch=feature/mxc-amd-gpu \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
    file://defconfig \
"
