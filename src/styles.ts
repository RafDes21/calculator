import { StyleSheet } from "react-native";
import { COLOR } from "./themes/colors";
import Constants from "expo-constants";

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: COLOR.neutro,
    padding: 20,
    marginTop: Constants.statusBarHeight,
  },
  totalContainer: {
    marginBottom: 10,
    width: "100%",
    height: 150,
    borderColor: COLOR.secondary,
    backgroundColor: COLOR.display,
    borderRadius: 5,
    alignItems: "flex-end",
    justifyContent: "flex-end",
    padding: 10,
  },
  btns: {
    width: "100%",
    flexDirection: "row",
    justifyContent: "space-between",
    backgroundColor: COLOR.neutro,
    borderRadius: 8,
  },
  row: {
    flexDirection: "row",
    justifyContent: "space-between",
  },
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
  operatorBtn: {
    backgroundColor: COLOR.secondary,
    alignItems: "center",
    justifyContent: "center",
    width: 60,
    height: 60,
    borderRadius: 30,
    margin: 10,
  },
  operatorsRow: {
    backgroundColor: COLOR.primary,
    borderRadius: 5,
  },
  operatorBtnText: {
    fontSize: 30,
    color: COLOR.operator,
  },
  btnsNumbers: {
    backgroundColor: COLOR.secondary,
    borderRadius: 5,
  },
});
