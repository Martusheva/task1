class Conformists extends Agent {
	public Conformists(boolean a, boolean st) {
		super(a, st);
	}

	public Conformists() {
		super();
	}

	@Override
	public String isConformist() {
		return "Conformist";
	}

	@Override
	public void computeOpinion(boolean opinionShareA) {// c-cross, r - rim, f - full graph
		if (opinionShareA) {
			changeOpinion('a');
		} else {
			changeOpinion('b');
		}
		
	}
}
