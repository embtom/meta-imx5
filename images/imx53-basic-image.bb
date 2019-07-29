SUMMARY = "A very basic imx53 basic image"

inherit uboot-fitimage
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
    libgles1-mesa \
    libgles2-mesa \
    libgbm \
    libglapi \
    haveged \
    "
IMAGE_INSTALL += "\
    qtbase \
    qtbase-plugins \
    qtsvg \
    qtsvg-plugins \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-qmlplugins \
    qtquickcontrols-qmlplugins \
    qtgraphicaleffects"

TOOLCHAIN_TARGET_TASK_append = " \
    libegl-mesa-dev \
    libgl-mesa-dev \
    libgles1-mesa-dev \
    libgles2-mesa-dev \
    libgbm-dev \
    libglapi-dev"
    
TOOLCHAIN_TARGET_TASK_remove="qtwebkit qtwebkit-dev"
TOOLCHAIN_HOST_TASK_remove  ="qtwebkit qtwebkit-dev"
PACKAGECONFIG_remove_pn-qttools = "qtwebkit qtwebkit-dev"
PACKAGECONFIG_remove_pn-qtquick1 = "qtwebkit qtwebkit-dev"
PACKAGECONFIG_remove_pn-qtbase = "qtwebkit qtwebkit-dev"

