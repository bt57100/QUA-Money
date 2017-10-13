package money;


public class Money {
	
	private String devise;
	private int montant;
	
	public Money(String currency, int amount) throws InvariantBroken{
		if (amount <=0){
			throw new InvariantBroken("Erreur. Doit etre >0");
			}else{
				if (currency.equals("")){
					throw new InvariantBroken ("erreur. Ne doit pas être vide");
					}else{
						devise = currency;
						montant = amount;
						}
			}
	}
	
	
	public String getDevise() {
		return devise;
	}
	
	public int getMontant() {
		return montant;
	}
	
	public Money add(Money mm) throws InvariantBroken{
		if(mm.getDevise().equals(this.devise)){
			return new Money(devise,this.getMontant()+mm.getMontant());
			}else{
				throw new InvariantBroken("On ne peut pas additionner 2 devises différentes");
				}	
		}
	
	public Money sub(Money mm) throws InvariantBroken{
		if(mm.getDevise().equals(this.devise)){
				return new Money(devise,this.getMontant()-mm.getMontant());
			}else{
				throw new InvariantBroken("On ne peut pas obtenir une monnaie de montant négatif");
				}	
		}
	
}
