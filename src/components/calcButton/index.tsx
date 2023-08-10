import React from "react";
import { TouchableHighlight, Text } from "react-native";
import { styles } from "./styles";
import { BtnsProps } from "../../types/types";


const CalcButton:React.FC<BtnsProps> = ({ label, onPress }) => (
  <TouchableHighlight
    underlayColor="#DDDDDD"
    onPress={() => onPress(label)}
    style={styles.btn}
  >
    <Text style={styles.btnText}>{label}</Text>
  </TouchableHighlight>
);

export default CalcButton;
