FROM node:lts as build

WORKDIR /build

COPY . .

RUN npm ci # das selbe wie npm install, ohne user interaktion

RUN npm run build

FROM nginx

COPY --from=build /build/dist/spengerclient/browser /usr/share/nginx/html

EXPOSE 80