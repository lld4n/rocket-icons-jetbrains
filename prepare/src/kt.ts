import { IconVariant, rocket } from "../rocket-icons";

export const named = (name: string, type: string, variant: string) => {
  return `${name}_${variant}_${type}`;
};

const stringify = (name: string, type: string, variant: string) => {
  let res = "@JvmField\n";
  res += `val ${named(name, type, variant)} = IconLoader.getIcon("/icons/${variant}/${type}/${name}.svg", javaClass)\n`;
  return res;
};

const prepare = () => {
  let res = "package com.github.lld4n.rocketiconsjetbrains\n";
  res += "import com.intellij.openapi.util.IconLoader\n";
  res += "class Icons {\n";
  return res;
};

export function kt() {
  let res = prepare();

  for (const type in rocket) {
    for (const variant in IconVariant) {
      for (const item of rocket[type]) {
        res += stringify(item.icon, type, variant.toLowerCase());
      }
    }
  }

  return res;
}
