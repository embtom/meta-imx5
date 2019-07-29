PACKAGES += "${PN}-toolchain-config"

FILES_${PN}-dev = "${OE_QMAKE_PATH_HEADERS}/* \
                   ${OE_QMAKE_PATH_ARCHDATA}/mkspecs\
                   ${OE_QMAKE_PATH_LIBS}/*.prl \
                   ${OE_QMAKE_PATH_LIBS}/*.la \
                   ${OE_QMAKE_PATH_LIBS}/lib*${SOLIBSDEV}\
                    "

FILES_${PN}-toolchain-config = "${OE_QMAKE_PATH_DATA}/cmake/*"                    