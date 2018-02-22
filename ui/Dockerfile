FROM node:latest
WORKDIR /tmp
COPY . /tmp/
RUN yarn install && yarn build

FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY /dist /usr/share/nginx/html