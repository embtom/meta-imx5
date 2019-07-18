inherit image_types kernel-artifact-names

FITIMAGE_KERNELIMG ?= "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}"
FITIMAGE_ROOTFS ?= "${IMGDEPLOYDIR}/${IMAGE_LINK_NAME}.jffs2"

itb_build () {

    echo "${IMAGE_NAME} - ${MACHINE} will build"
    echo "Kernel: ${FITIMAGE_KERNELIMG}"
    echo "Rootfs: ${FITIMAGE_ROOTFS}"
    echo "${IMAGE_BOOT_FILES}"

    if [ -n "${KERNEL_DEVICETREE}" ]; then
      dtbcount=1
      for DTB in ${KERNEL_DEVICETREE}; do
        DTB_FILE=`basename ${DTB} | sed 's,\.dts$,.dtb,g'`
        FITIMAGE_DTBIMG="${DEPLOY_DIR_IMAGE}/${DTB_FILE}"
        ITS_FILE="${DTB_FILE%%.*}.its"
        ITB_FILE="${DTB_FILE%%.*}.itb"
	      rm -f ${IMGDEPLOYDIR}/${ITS_FILE}
        rm -f ${DEPLOY_DIR_IMAGE}/${ITB_FILE}
        echo "Generating ${IMGDEPLOYDIR}/${DTB_FILE}.its"
        cat << EOF >> ${IMGDEPLOYDIR}/${ITS_FILE}
/dts-v1/;
/ {
  description = "U-Boot fitImage for ${DISTRO_NAME}/${PV}/${MACHINE}";
  #address-cells = <1>;
  hardware_t = <0x48>;

  images {
    update@1 {
      description = "Linux Rootfs";
      data = /incbin/("${FITIMAGE_ROOTFS}");
      compression = "none";
      arch = "arm";
      type = "firmware";
      load = <0xF0600000>;
      hash@1 {
		    algo = "sha1";
      };
    };

    update@2 {
      description = "Linux Kernel";
      data = /incbin/("${FITIMAGE_KERNELIMG}");
      compression = "none";
      arch = "arm";
      type = "firmware";
      load = <0xF0100000>;
      hash@1 {
		    algo = "sha1";
      };
    };

    update@3 {
      description = "Linux DTB";
      data = /incbin/("${FITIMAGE_DTBIMG}");
      compression = "none";
      arch = "arm";
      type = "firmware";
      load = <0xF0500000>;
      hash@1 {
		    algo = "sha1";
      };
    };
  };
};
EOF

      mkimage -f ${IMGDEPLOYDIR}/${ITS_FILE} ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.itb
      rm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.itb
      ln -s ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.itb ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.itb

      done
    fi


}

IMAGE_TYPEDEP_uboot-itb = "jffs2"
do_image_uboot_itb[depends] = "\
                          u-boot-mkimage-native:do_populate_sysroot \
                          virtual/kernel:do_deploy"

IMAGE_CMD_uboot-itb = "itb_build"
