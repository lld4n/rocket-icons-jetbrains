import fs = require("fs");

export function start() {
  try {
    fs.rmSync("./src/main/resources/icons", { recursive: true });
    fs.mkdirSync("./src/main/resources/icons");
    fs.writeFileSync("./src/main/resources/icons/.gitkeep", "");
  } catch (e) {}
}
