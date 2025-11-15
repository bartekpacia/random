FROM alpine:3.22

RUN apk add micro shadow zsh

RUN chsh -s /bin/zsh root

COPY .zshrc /root/

CMD ["/bin/zsh"]
