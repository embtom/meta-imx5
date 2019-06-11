# Enable freedreno driver
PACKAGECONFIG_append = "egl gbm gallium "
GALLIUMDRIVERS_append = ",freedreno,kmsro,vc4"

SRC_URI_append = "file://0005-winsys-imx_drm-msm-load.patch"


INSANE_SKIP_mesa-megadriver += "dev-so"

do_install_append () {
    install -d ${D}${libdir}/dri
    ln -s -r ${D}${libdir}/dri/pl111_dri.so ${D}${libdir}/dri/imx-drm_dri.so
}