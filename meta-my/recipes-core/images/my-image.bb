require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL:append = " \
  libgpiod meshtasticd \
  wpa-supplicant \
  iw \
  linux-firmware \
  kernel-modules \
"
