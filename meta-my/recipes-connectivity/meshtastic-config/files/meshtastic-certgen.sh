#!/bin/sh
set -e

CERT_DIR=/etc/meshtasticd/ssl
CERT=$CERT_DIR/certificate.pem
KEY=$CERT_DIR/private_key.pem

if [ -f "$CERT" ] && [ -f "$KEY" ]; then
    exit 0
fi

mkdir -p "$CERT_DIR"

openssl req -x509 \
    -newkey rsa:2048 \
    -nodes \
    -days 3650 \
    -subj "/CN=$(hostname)" \
    -keyout "$KEY" \
    -out "$CERT"

chmod 600 "$KEY"
chmod 644 "$CERT"
