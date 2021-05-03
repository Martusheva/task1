
class Nonconformists extends Agent {
	public Nonconformists(boolean a, boolean st) {
		super(a, st);
	}

	public Nonconformists() {
		super();
	}

	@Override
	public String isConformist() {
		return "Nonconformist";
	}

	@Override
	public void computeOpinion(boolean opinionShareA) {
		if (opinionShareA) {
			changeOpinion('b');
		} else {
			changeOpinion('a');
		}
	}
}
