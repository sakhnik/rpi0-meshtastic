SUMMARY = "WiFi configuration"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
  file://wpa_supplicant.conf \
  file://S40wifi \
"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "S40wifi"
INITSCRIPT_PARAMS = "defaults 40"

do_install() {

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/S40wifi ${D}${sysconfdir}/init.d/S40wifi

    install -d ${D}${sysconfdir}
    install -m 0600 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}/wpa_supplicant.conf
}
