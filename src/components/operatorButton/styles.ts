import { StyleSheet } from "react-native";
import { COLOR } from "../../themes/colors";

export const styles = StyleSheet.create({
  operatorBtnText: {
    fontSize: 30,
    color: COLOR.operator,
  },
  operatorBtn: {
    backgroundColor: COLOR.secondary,
    alignItems: "center",
    justifyContent: "center",
    width: 60,
    height: 60,
    borderRadius: 30,
    margin: 10,
  },
});
