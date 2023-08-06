import React from "react";
import { View, Text, TouchableHighlight } from "react-native";
import { styles } from "./styles";

const App = () => {
  const onPress = () => {};

  return (
    <View style={styles.container}>
      <View style={styles.totalContainer}>
        <Text style={styles.totalText}>Total</Text>
      </View>
      <View style={styles.btns}>
        <View>
        <View style={styles.row}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>AC</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>%</Text>
          </TouchableHighlight>
        </View>
        <View style={styles.row}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>9</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>8</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>7</Text>
          </TouchableHighlight>
        </View>
        <View style={styles.row}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>6</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>5</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>4</Text>
          </TouchableHighlight>
        </View>
        <View style={styles.row}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>3</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>2</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>1</Text>
          </TouchableHighlight>
        </View>
        <View style={styles.row}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>0</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.btn}
          >
            <Text>.</Text>
          </TouchableHighlight>
        </View>

        </View>
        <View style={styles.operatorsRow}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text>+</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text>-</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text>x</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text>/</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text>=</Text>
          </TouchableHighlight>
        </View>
      </View>
    </View>
  );
};

export default App;