import { StyleSheet } from "react-native";
import { COLOR } from "../../themes/colors";

export const styles = StyleSheet.create({
  btn: {
    backgroundColor: COLOR.primary,
    alignItems: "center",
    justifyContent: "center",
    width: 63,
    height: 63,
    borderRadius: 30,
    marginVertical: 10,
    marginHorizontal: 15,
  },
  btnText: {
    color: COLOR.neutro,
    fontSize: 20,
  },
});
