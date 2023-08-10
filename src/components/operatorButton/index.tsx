import React from "react";
import { TouchableHighlight, Text } from "react-native";
import { styles } from "./styles";
import { BtnsProps } from "../../types/types";

const OperatorButton: React.FC<BtnsProps> = ({ label, onPress }) => (
  <TouchableHighlight
    underlayColor="#DDDDDD"
    onPress={() => onPress(label)}
    style={styles.operatorBtn}
  >
    <Text style={styles.operatorBtnText}>{label}</Text>
  </TouchableHighlight>
);

export default OperatorButton;
