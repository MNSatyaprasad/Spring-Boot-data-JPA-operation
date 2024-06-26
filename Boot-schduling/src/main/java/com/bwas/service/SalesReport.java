package com.bwas.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SalesReport {

	/*
	 * @Scheduled(initialDelay = 2000, fixedDelay = 3000) public void
	 * generateSalesReport() { System.out.println("Sales Report Generation  " + new
	 * Date()); }
	 */

	/*
	 * @Scheduled(fixedDelay = 5000) public void generateSalesReport() {
	 * System.out.println("Sales Report Generation  " + new Date()); }
	 */

	/*
	 * @Scheduled(fixedRate = 5000) public void generateSalesReport() {
	 * 
	 * try { Thread.sleep(10000); System.out.println("Sales Report Generation  " +
	 * new Date()); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	/*
	 * @Scheduled(initialDelay = 4000, fixedDelay = 5000) public void
	 * generateSalesReport() { System.out.println("Sales Report Generation  " + new
	 * Date() + " " + Thread.currentThread().getName()); }
	 */

	/*
	 * @Scheduled(cron = "15 * * * * *") public void generateSalesReport() {
	 * System.out.println("Sales Report Generation  " + new Date()); }
	 */
	/*
	 * @Scheduled(cron = "15 39 12 * * *") public void generateSalesReport() {
	 * System.out.println("Sales Report Generation  " + new Date()); }
	 */
	/*
	 * @Scheduled(cron = "* * * * * *") public void generateSalesReport() {
	 * System.out.println("Sales Report Generation  " + new Date()); }
	 */
	/*
	 * @Scheduled(cron = "15 * * * * *") public void generateSalesReport() {
	 * System.out.println("Sales Report Generation  " + new Date()); }
	 */
	/*
	 * @Scheduled(cron = "0/30 * * * * *") public void generateSalesReport() {
	 * System.out.println("Sales Report Generation  " + new Date()); }
	 */
	@Scheduled(cron = "0 0/3 * * * *")
	public void generateSalesReport() {
		System.out.println("Sales Report Generation  " + new Date());
	}
}
