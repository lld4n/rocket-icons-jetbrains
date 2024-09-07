// val EXT_TO_ICONS = mapOf(
//     "aep" to adobe_ae,
//     "ai" to adobe_ai,
// )

import { folders, IconVariant, rocket } from "../rocket-icons";
import { named } from "./kt";

export function kt_map() {
  let md = "";
  for (const type in rocket) {
    if (type === "common") continue;
    let map = `\nval ${type} = mapOf(\n`;
    for (const icon of rocket[type]) {
      for (const filename of icon.filenames) {
        map += `"${filename}" to ${named(icon.icon, type)},\n`;
      }
    }
    map += `)\n`;
    md += map;
  }

  let map = `\nval folders = mapOf(\n`;
  for (const icon of folders) {
    for (const filename of icon.filenames) {
      map += `"${filename}" to ${icon.icon}_folders,\n`;
    }
  }
  map += `)\n`;
  md += map;

  return md;
}
