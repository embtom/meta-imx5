SUMMARY = "A very basic imx53 basic image"

include recipes-core/images/core-image-minimal.bb

#IMAGE_FEATURES += "splash x11-base"

IMAGE_INSTALL += " \
    firmware-imx \
    firmware-imx-sdma-imx53 \
    kernel-modules \
    firmware-imx \
    rng-tools \
    mtd-utils \
    net-tools \
    tslib \
    tslib-calibrate \
    tslib-tests \
    linux-input \
    libdrm-freedreno \
    libdrm-tests \
    mesa-megadriver \
    libegl-mesa \
    libgl-mesa \
    libgles1-mesa \
    libgles2-mesa \
    libgbm \
    libglapi \
    mesa-demos \
    haveged \
    "

TOOLCHAIN_TARGET_TASK_append = " \
    libegl-mesa-dev \
    libgl-mesa-dev \
    libgles1-mesa-dev \
    libgles2-mesa-dev \
    libgbm-dev \
    libglapi-dev"
    


REQUIRED_DISTRO_FEATURES = "x11"
