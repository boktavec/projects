const dgram = require("dgram");
const server = dgram.createSocket("udp4");

const ADDRESS = "127.0.0.1";
const PORT = 50000;

server.bind({
  port: PORT,
  address: ADDRESS,
});

const client1 = dgram.createSocket("udp4");

server.on("message", (msg) => {
  // console.log(msg);
  client1.send(msg, 50001, ADDRESS, (err) => {
    if (err) {
      console.log("error", err);
      return;
    }
    console.log("Ingress received and sent message");
  });
});
