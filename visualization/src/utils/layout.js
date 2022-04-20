export default function computeLayout (layout) {
  const { size, components } = layout;
  const [width, height] = size;
  const list = [];

  for (let i = 0; i < components.length; ++i) {
    const item = components[i];
    const inlineStyles = {
      x: `${(item.x * 100)/width}%`,
      y: `${(item.y * 100)/height}%`,
      width: `${(item.width * 100)/width}%`,
      height: `${(item.height * 100)/height}%`,
      zIndex: item.z
    }
    list.push({
      inlineStyles,
      use: item.use
    })
  }
  return list;
}