echo "Obtaining address..."

sleep 1

ipAddress=$(ip -4 addr show eth0 | grep -oP '(?<=inet\s)\d+(\.\d+){3}')

echo "$ipAddress" > internal_ip.txt

echo "IP address has been saved to internal_ip.txt"

read -p "Press Enter to exit..."
