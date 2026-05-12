#!/bin/bash

target=/dev/sda

sudo umount $target*
sudo bmaptool copy build/tmp/deploy/images/raspberrypi0-wifi/my-image-raspberrypi0-wifi.rootfs.wic.bz2 $target
