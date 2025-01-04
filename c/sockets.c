#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <unistd.h>

#define SERVER_PORT 2137
#define BUFFER_SIZE 4096

int main() {
    int sockfd;
    char buffer[BUFFER_SIZE];

    sockfd = socket(PF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        fprintf(stderr, "error creating socket\n");
        return 1;
    }

    // Step 2: Get the server address
    struct hostent* server = gethostbyname("localhost");
    if (server == NULL) {
        fprintf(stderr, "error: no such host\n");
        close(sockfd);
        return 1;
    }

    // Step 3: Setup the server address structure
    struct sockaddr_in addr;  // server address
    memset(&addr, 0, sizeof(addr));
    addr.sin_family = AF_INET;
    bcopy((char*)server->h_addr, (char*)&addr.sin_addr.s_addr,
          server->h_length);
    addr.sin_port = htons(SERVER_PORT);

    // Step 4: Connect to the server
    int err = connect(sockfd, (struct sockaddr*)&addr, sizeof(addr));
    if (err < 0) {
        fprintf(stderr, "error connecting to server\n");
        close(sockfd);
        return 1;
    }

    // Step 5: Prepare the HTTP request
    char* http_request =
        "GT / HTTP/1.1\r\n"
        "Host: localhost:2137\r\n"
        "Accept: */*\r\n"
        "User-Agent: barteks-dummy-client\r\n"
        "\r\n";

    // Step 6: Send the HTTP request
    err = write(sockfd, http_request, strlen(http_request));
    if (err < 0) {
        fprintf(stderr, "error writing to socket\n");
        close(sockfd);
        return 1;
    }

    // Step 7: Read the server's response
    memset(buffer, 0, BUFFER_SIZE);
    int bytes_read = read(sockfd, buffer, BUFFER_SIZE - 1);
    if (bytes_read < 0) {
        fprintf(stderr, "error reading from socket\n");
        close(sockfd);
        return 1;
    } else {
        fprintf(stderr, "got response!\n");
        printf("%s\n", buffer);
        close(sockfd);
    }

    return 0;
}
