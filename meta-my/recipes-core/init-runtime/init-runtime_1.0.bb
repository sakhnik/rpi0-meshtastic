SUMMARY = "Early runtime mounts for SysVinit"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://S00mounts"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "S00mounts"
INITSCRIPT_PARAMS = "start 00 S ."

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/S00mounts ${D}${sysconfdir}/init.d/S00mounts
}
