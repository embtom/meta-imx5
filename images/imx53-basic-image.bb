SUMMARY = "A very basic image"

include recipes-core/images/core-image-minimal.bb

#IMAGE_FEATURES += "ssh-server-dropbear openssh-sftp-server"

IMAGE_INSTALL += " \
    firmware-imx \
    firmware-imx-sdma-imx53 \
    amd-gpu-bin-mx51 \
    kernel-modules \
    firmware-imx \
    rng-tools \
    mtd-utils \
    net-tools \
    tslib \
    tslib-calibrate \
    tslib-tests \
    linux-input \
    "

TOOLCHAIN_TARGET_TASK_append = " \
     amd-gpu-bin-mx51-dev"
    



