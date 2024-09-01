import { start } from "./src/start";
import { icons } from "./src/icons";
import { kt } from "./src/kt";
import { kt_map } from "./src/map";
import * as fs from "node:fs";

const prepare = () => {
  let content = kt();
  content += kt_map();
  content += "}";
  fs.writeFileSync(
    "src/main/kotlin/com/github/lld4n/rocketiconsjetbrains/Icons.kt",
    content,
    { encoding: "utf-8" },
  );
};

start();
icons();
prepare();
