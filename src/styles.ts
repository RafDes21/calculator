import { StyleSheet } from "react-native";
import { COLOR } from "./themes/colors";

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF",
    padding: 20,
  },
  totalContainer: {
    marginBottom: 10,
    width: "100%",
    height:150,
    borderWidth:1,
    borderColor: COLOR.secondary,
    borderRadius:5,
    alignItems:"flex-end",
    justifyContent:"flex-end",
    padding: 10,
  },
  totalText: {
    fontSize: 24,
    fontWeight: "bold",
  },
  btns: {
    width: "100%",
    flexDirection:"row",
    justifyContent: "space-between",
    backgroundColor: COLOR.neutro,
    padding:10,
    borderRadius:8,
  },
  row: {
    flexDirection: "row",
    justifyContent: "space-between",
  },
  btn: {
    backgroundColor: COLOR.primary,
    alignItems: "center",
    justifyContent: "center",
    width: 60,
    height: 60,
    borderRadius: 30,
    marginVertical:10,
    marginHorizontal: 15,
  },
  btnText:{
    color: COLOR.neutro,
    fontSize:20,
  },
  operatorBtn: {
    backgroundColor: COLOR.secondary,
    alignItems: "center",
    justifyContent: "center",
    width: 60,
    height: 60,
    borderRadius: 30,
    margin:10,
  },
  operatorsRow:{
  
  },
  operatorBtnText:{
    fontSize:30,
    color: COLOR.operator,
  }

});
