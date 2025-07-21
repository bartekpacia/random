### single bot instance


- marcin - user
|
|
- tworca tg-sh-bota / maintainer serwera na ktorym stoi tg-sh-bot
|
|
- serwer marcinxxx@shilangyu.dev


### single bot instance per server per user

ls ----> @tg-sh-bot

vps1.pacia.tech: process th-sh-bot #1

vps2.pacia.tech: process th-sh-bot #2

### single bot instance per user

I want to build a Telegram bot that will allow me for Remote Code Execution
on my personal/private servers.

Here is the idea for the public API of my bot (i.e. the commands it will have).

### Listing servers

> /list-servers
vps1 vps1.pacia.tech
vps2 vps2.pacia.tech
dupa vps3.pacia.tech


### Adding servers to the list

> /add-server dupa vps3.pacia.tech

server alias: dupa
server address: vps3.pacia.tech
username: user
public key (plaintext, to be uploaded as telegram file)

- OK Added to list of saved server!

Description:
This command needs to take some input from the user:
- IP address of the server
- username at the server
- public ssh key (upload as an attachment/file in the telegram conversation)

This data has to be saved somewhere. For now, just use the filesystem, with the
following structure:

```
/bartekpacia (the user)
  - data.json
/shilangyu (the user)
  - data.json
```

The data.json files contain all the data for the user: their list of saved servers,
along with the data for each server.

### Connecting to the server

> /ssh vps1.pacia.tech

This initiates an ssh connection to the server.

Instead of relying on the built-in ssh binary, use the golang.org/x/crypto/ssh
module instead.

After I am connected to the server, I can type commands and they are run
in the ssh session. Example usage:

```
> pwd
/home/user

> ls
.bashrc

> mkdir projects
> cd projects

> pwd
/home/user/projects

> /exit # i quit from the server. The slash is interpreter as a TG command.
```

And then I can change the server I'm currently signed to:

> /ssh vps2.pacia.tech
