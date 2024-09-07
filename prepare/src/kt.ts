import { folders, IconVariant, rocket } from "../rocket-icons";

export const named = (name: string, type: string) => {
  return `${name}_${type}`;
};

const stringify = (name: string, type: string) => {
  let res = "@JvmField\n";
  res += `val ${named(name, type)} = IconLoader.getIcon("/icons/$variant/${type}/${name}.svg", javaClass)\n`;
  return res;
};

const prepare = () => {
  let res = "package com.github.lld4n.rocketiconsjetbrains\n";
  res += "import com.intellij.openapi.util.IconLoader\n";
  res += "class Icons(variant: String, subtype: String) {\n";
  return res;
};

export function kt() {
  let res = prepare();

  for (const type in rocket) {
    for (const item of rocket[type]) {
      res += stringify(item.icon, type);
    }
  }

  for (const item of folders) {
    res += "@JvmField\n";
    res += `val ${item.icon}_folders = IconLoader.getIcon("/icons/$variant/$subtype/${item.icon}.svg", javaClass)\n`;
  }

  return res;
}
