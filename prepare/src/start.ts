import fs = require("fs");

export function start() {
  fs.rmSync("./src/main/resources/icons", { recursive: true });
  fs.mkdirSync("./src/main/resources/icons");
}
