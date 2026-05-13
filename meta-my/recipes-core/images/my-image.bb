require recipes-core/images/core-image-minimal.bb

inherit extrausers

IMAGE_INSTALL:append = " \
  libgpiod meshtasticd \
  wpa-supplicant \
  iw \
  wireless-regdb \
  wifi-config \
  busybox \
  init-runtime \
"

IMAGE_INSTALL:remove = " \
  bluez5 \
"

IMAGE_FEATURES += "ssh-server-dropbear"
DROPBEAR_EXTRA_ARGS = "-s"

ROOTFS_POSTPROCESS_COMMAND += "setup_dropbear_keys;"

setup_dropbear_keys () {
    install -d ${IMAGE_ROOTFS}/home/root/.ssh


    echo "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIM2GbWlGJN5XQd6Ca8i+XyIQsFowhkhbF4Q+hlG38iz/ sakhnik@vivo" \
        > ${IMAGE_ROOTFS}/home/root/.ssh/authorized_keys

    chmod 700 ${IMAGE_ROOTFS}/home/root/.ssh
    chmod 600 ${IMAGE_ROOTFS}/home/root/.ssh/authorized_keys
}
