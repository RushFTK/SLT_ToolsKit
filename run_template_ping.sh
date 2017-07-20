#get target address
read -p "Target_IPaddress:" target_address
if [ -z $target_address]
then
	echo "You must input target ip address"
	echo "the program will also return 'usage [-v] <address>' if you run it direactorly"
	exit -1
fi
#　goto cloned directory (if not found,change the next line)
cd ~/SLT_ToolsKit
# goto template_ping directory
cd template_program/simple_ping
# compile sample directory (warning)
gcc ping.c -o ping 
# run programs(if not use sudo,then a error occured :no write promission)
sudo ./ping $target_address

