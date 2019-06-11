FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
DEPENDS_append = " tslib mesa libdrm"
RDEPENDS_${PN}_append = " tslib-calibrate"

SRC_URI_append = "file://qt5.sh"

PACKAGECONFIG_RELEASE = "release"
PACKAGECONFIG_FONTS = "fontconfig"
PACKAGECONFIG_DEFAULT_append = " accessibility udev evdev libinput eglfs gles2 gbm kms tslib"
PACKAGECONFIG_DEFAULT_remove = " tests"

QT_CONFIG_FLAGS_append = " -tslib -qpa eglfs"

#disable webkit build
PACKAGECONFIG_remove_pn-qttools = "qtwebkit"
PACKAGECONFIG_remove_pn-qtquick1 = "qtwebkit"

#install environment variables
do_install_append() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/qt5.sh ${D}${sysconfdir}/profile.d/
}

#-qreal float