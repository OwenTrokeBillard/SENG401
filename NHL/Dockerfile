FROM node:14.2

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli@9.1

# add app
COPY . /app

# build
RUN ng build

# run
CMD ["ng", "serve", "--host", "0.0.0.0"]