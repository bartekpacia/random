#!/bin/sh
set -eu

cd "$(dirname "$0")"
mkdir -p assets

KERNEL_URL="https://s3.amazonaws.com/spec.ccfc.min/firecracker-ci/20261008-40f3a4819490-0/x86_64/vmlinux-6.18.51"
ROOTFS_URL="https://dl-cdn.alpinelinux.org/alpine/v3.24/releases/x86_64/alpine-minirootfs-3.24.2-x86_64.tar.gz"

for url in "$KERNEL_URL" "$ROOTFS_URL"; do
  file="assets/$(basename "$url")"
  if [ -f "$file" ]; then
    echo "skip: $file already exists"
  else
    echo "download: $url"
    curl -fL -o "$file" "$url"
  fi
done
