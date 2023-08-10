export const hasMatchingOperator = (inputOperator: string): boolean => {
  const allowedOperators = ["+", "-", "%", "/"];
  return allowedOperators.includes(inputOperator);
};
