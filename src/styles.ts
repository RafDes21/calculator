import { StyleSheet } from "react-native";

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF",
  },
  totalContainer: {
    marginBottom: 10,
  },
  totalText: {
    fontSize: 24,
    fontWeight: "bold",
  },
  btns: {
    paddingHorizontal: 20,
    flexDirection:"row"
  },
  row: {
    flexDirection: "row",
    justifyContent: "space-between",
    
  },
  btn: {
    backgroundColor: "#808080",
    alignItems: "center",
    justifyContent: "center",
    width: 60,
    height: 60,
    borderRadius: 30,
    margin:10,
  },
  operatorBtn: {
    backgroundColor: "#DDDDDD",
    alignItems: "center",
    justifyContent: "center",
    width: 60,
    height: 60,
    borderRadius: 30,
    margin:10,
  },
  operatorsRow:{},

});
