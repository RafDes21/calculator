import { View } from "react-native";
import { ContentButtonProps } from "../../types/types";
import {styles} from "./styles"

const contentButton: React.FC<ContentButtonProps> = ({ children, style }) => {
  return <View style={{...styles.container, ...style}} >{children}</View>;
};

export default contentButton;
