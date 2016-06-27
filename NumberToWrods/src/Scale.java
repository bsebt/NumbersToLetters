public enum Scale {
	SHORT, LONG;

	public String getName(int exponent) {
		for (ScaleUnit unit : ScaleUnit.SCALE_UNITS) {
			if (unit.getExponent() == exponent) {
				return unit.getName(this.ordinal());
			}
		}
		return "";
	}
}