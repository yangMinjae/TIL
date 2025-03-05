package org.joonzis.test;

public class Test02 {
	public static void main(String[] args) {
		TourGuide tour1 = new TourGuide(new KoreaTour());
		tour1.tourStart();
		TourGuide tour2 = new TourGuide(new GuamTour());
		tour2.tourStart();
	}
}
interface Providable{
	void sightseeing();
	void leisure();
	void food();
}
class KoreaTour implements Providable{
	@Override
	public void sightseeing() {
		// TODO Auto-generated method stub
		System.out.println("경복궁 관광");
	}
	@Override
	public void leisure() {
		// TODO Auto-generated method stub
		System.out.println("설악산 스키");
	}
	@Override
	public void food() {
		// TODO Auto-generated method stub
		System.out.println("전주 비빔밥");
	}
}
class GuamTour implements Providable{
	@Override
	public void sightseeing() {
		// TODO Auto-generated method stub
		System.out.println("섬 투어");
	}
	@Override
	public void leisure() {
		// TODO Auto-generated method stub
		System.out.println("스노클링");
	}
	@Override
	public void food() {
		// TODO Auto-generated method stub
		System.out.println("코코넛 크랩");
	}
}
class TourGuide{
	Providable tour;
	public TourGuide() {}
	public TourGuide(Providable tour) {
		super();
		this.tour = tour;
	}
	public void sightseeing() {
		tour.sightseeing();
	}
	public void leisure() {
		tour.leisure();
	}
	public void food() {
		tour.food();
	}
	public void tourStart() {
		sightseeing();
		leisure();
		food();
		System.out.println();
	}
}
