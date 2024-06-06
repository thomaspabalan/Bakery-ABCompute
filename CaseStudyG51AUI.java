// COMPLETED 03-29-2022 03:19
// Main class for the bakery program

package caseStudy;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class CaseStudyG51AUI extends JFrame implements ActionListener, ChangeListener {

	private JPanel contentPane;
	private Color bg;
	private Color gray;
	private JTabbedPane tabbedPane;
	private JTextField textFieldInputName;
	private JTextField textFieldItemNum;
	private JTextField textFieldItemQuantity;
	private JPanel mainPanel;
	private JPanel transactionPanel;
	private JLabel lblErrorTransac;
	private JScrollPane scrollPaneMainMenu;
	private CardLayout crd;
	private CardLayout crd2;
	private JButton btnNewTransac;
	private JButton btnCheckout;
	private JTable tableList;
	private JTable tableSummary1;
	private JTable tableSummary2;
	private JTable tableSummary3;
	private JTable tableSalesReport;
	private JTable tableStocks;
	private JButton btnDoneSummary;
	private JTable tableItem;
	private JTextField textFieldItemName;
	private JTextField textFieldItemPrice;
	private JTextField textFieldItemStock;
	private JTextField textFieldRemoveItem;
	private JTextField textFieldAddStockItemNum;
	private JTextField textFieldAddStock;
	private JButton btnDefaultFile;
	private JTextField textFieldPayment;
	private JButton btnAddCart;
	private JButton btnCustomFile;
	private JButton btnOpenFile;
	private JLabel lblFileOpen;
	private JPanel panelCustomFile;
	private JLabel lblTypeNum;
	private JTextField textFieldTableCreate;
	private JButton btnCreateTempTable;
	private JScrollPane scrollPaneTempTable;
	private JButton btnTempTableDone;
	private JLabel lblEditTable;
	private JLabel lblEditTableTitle;
	private JTable tempTable;
	private JLabel lblTempTableState;
	private JPanel filePanel;
	private JButton btnAddItem;
	private JButton btnRemoveItem;
	private JButton btnAddStock;
	private JLabel lblEditTable_1;
	private JLabel lblErrName;
	private boolean fileOpen;
	private boolean tempTableLoaded;
	private JLabel lblErrorStock;
	private JLabel lblGrpName;
	private JButton btnSaveFile;
	private JFileChooser fileChoose;
	private JButton btnDeleteFile;
	private boolean orderInProgress;
	private boolean listenChange;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaseStudyG51AUI frame = new CaseStudyG51AUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CaseStudyG51AUI() {
		
		bg = new Color(255, 199, 248);
		gray = new Color(240, 240, 240);
		crd = new CardLayout(0, 0);
		crd2 = new CardLayout(0, 0);
		fileOpen = false;
		tempTableLoaded = false;
		orderInProgress = false;
		listenChange = false;
		
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setMinimumSize(new Dimension(400, 500));
		setPreferredSize(new Dimension(400, 500));
		setSize(450, 500);
		setResizable(false);
		setTitle("ABCompute");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UIManager.put("TabbedPane.selected", bg);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(this);
		tabbedPane.setBackground(new Color(240, 240, 240));
		tabbedPane.setFont(new Font("Courier New", Font.PLAIN, 11));
		tabbedPane.setBounds(0, 0, 434, 461);
		contentPane.add(tabbedPane);
		
		filePanel = new JPanel();
		filePanel.setBackground(bg);
		tabbedPane.addTab("File", null, filePanel, "Manage Files");
		filePanel.setLayout(crd2);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(bg);
		filePanel.add(panelMain, "main");
		panelMain.setLayout(null);
		
		btnDefaultFile = new JButton("New Default File");
		btnDefaultFile.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnDefaultFile.addActionListener(this);
		btnDefaultFile.setBounds(85, 70, 258, 36);
		panelMain.add(btnDefaultFile);
		
		btnCustomFile = new JButton("New Custom File");
		btnCustomFile.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnCustomFile.addActionListener(this);
		btnCustomFile.setBounds(85, 135, 258, 36);
		panelMain.add(btnCustomFile);
		
		btnOpenFile = new JButton("Open File");
		btnOpenFile.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnOpenFile.addActionListener(this);
		btnOpenFile.setBounds(85, 200, 258, 36);
		panelMain.add(btnOpenFile);
		
		lblFileOpen = new JLabel("");
		lblFileOpen.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblFileOpen.setBounds(10, 408, 409, 14);
		panelMain.add(lblFileOpen);
		
		btnSaveFile = new JButton("Save File");
		btnSaveFile.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnSaveFile.addActionListener(this);
		btnSaveFile.setBounds(85, 265, 258, 36);
		panelMain.add(btnSaveFile);
		
		btnDeleteFile = new JButton("Delete File");
		btnDeleteFile.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnDeleteFile.addActionListener(this);
		btnDeleteFile.setBounds(85, 330, 258, 36);
		panelMain.add(btnDeleteFile);
		
		panelCustomFile = new JPanel();
		panelCustomFile.setBackground(bg);
		filePanel.add(panelCustomFile, "custom file");
		panelCustomFile.setLayout(null);
		
		lblTypeNum = new JLabel("Input number of items:");
		lblTypeNum.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblTypeNum.setBounds(10, 56, 159, 14);
		panelCustomFile.add(lblTypeNum);
		
		textFieldTableCreate = new JTextField();
		textFieldTableCreate.setFont(new Font("Courier New", Font.PLAIN, 11));
		textFieldTableCreate.setBounds(10, 74, 149, 23);
		panelCustomFile.add(textFieldTableCreate);
		textFieldTableCreate.setColumns(10);
		
		btnCreateTempTable = new JButton("Create Table");
		btnCreateTempTable.addActionListener(this);
		btnCreateTempTable.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnCreateTempTable.setBounds(10, 104, 149, 25);
		panelCustomFile.add(btnCreateTempTable);
		
		scrollPaneTempTable = new JScrollPane();
		scrollPaneTempTable.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneTempTable.setBackground(gray);
		scrollPaneTempTable.setBounds(10, 175, 409, 180);
		panelCustomFile.add(scrollPaneTempTable);
		
		tempTable = new JTable();
		tempTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tempTable.setRowSelectionAllowed(false);
		tempTable.getTableHeader().setResizingAllowed(false);
		tempTable.getTableHeader().setReorderingAllowed(false);
		tempTable.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		tempTable.setModel(new DefaultTableModel());
		tempTable.setBackground(gray);
		scrollPaneTempTable.setViewportView(tempTable);
		
		btnTempTableDone = new JButton("Done");
		btnTempTableDone.addActionListener(this);
		btnTempTableDone.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnTempTableDone.setBounds(169, 389, 89, 23);
		panelCustomFile.add(btnTempTableDone);
		
		lblEditTable = new JLabel("Edit Table Below:");
		lblEditTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditTable.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblEditTable.setBounds(135, 152, 159, 14);
		panelCustomFile.add(lblEditTable);
		
		lblEditTableTitle = new JLabel("Create New Table");
		lblEditTableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditTableTitle.setFont(new Font("Courier New", Font.BOLD, 14));
		lblEditTableTitle.setBounds(135, 11, 159, 29);
		panelCustomFile.add(lblEditTableTitle);
		
		lblTempTableState = new JLabel("");
		lblTempTableState.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblTempTableState.setBounds(10, 416, 409, 14);
		panelCustomFile.add(lblTempTableState);
		
		lblEditTable_1 = new JLabel("Note: Press Enter before clicking Done");
		lblEditTable_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditTable_1.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblEditTable_1.setBounds(76, 367, 279, 14);
		panelCustomFile.add(lblEditTable_1);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(bg);
		tabbedPane.addTab("Main Menu", null, mainPanel, "Menu and Transactions");
		mainPanel.setLayout(crd);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(bg);
		mainPanel.add(menuPanel, "menu");
		menuPanel.setLayout(null);
		
		btnNewTransac = new JButton("New Transaction");
		btnNewTransac.addActionListener(this);
		btnNewTransac.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnNewTransac.setBounds(84, 369, 261, 37);
		menuPanel.add(btnNewTransac);
		
		JLabel labelMainName = new JLabel("<html>&nbsp; ABC<br>BAKERY</html>");
		labelMainName.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
		labelMainName.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainName.setBounds(10, 85, 409, 188);
		menuPanel.add(labelMainName);
		
		JLabel labelEnterName = new JLabel("Enter Name:");
		labelEnterName.setFont(new Font("Courier New", Font.PLAIN, 11));
		labelEnterName.setBounds(47, 311, 335, 20);
		menuPanel.add(labelEnterName);
		
		textFieldInputName = new JTextField();
		textFieldInputName.setFont(new Font("Courier New", Font.PLAIN, 12));
		textFieldInputName.setBounds(47, 331, 335, 27);
		menuPanel.add(textFieldInputName);
		textFieldInputName.setColumns(10);
		
		lblErrName = new JLabel("");
		lblErrName.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblErrName.setBounds(10, 412, 409, 14);
		menuPanel.add(lblErrName);
		
		JLabel lblHeaderMain = new JLabel("H E L L O !   W E L C O M E   T O");
		lblHeaderMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderMain.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		lblHeaderMain.setBounds(10, 37, 409, 27);
		menuPanel.add(lblHeaderMain);
		
		transactionPanel = new JPanel();
		transactionPanel.setBackground(bg);
		mainPanel.add(transactionPanel, "transac");
		transactionPanel.setLayout(null);
		
		scrollPaneMainMenu = new JScrollPane();
		scrollPaneMainMenu.setBackground(gray);
		scrollPaneMainMenu.setBounds(10, 43, 409, 180);
		scrollPaneMainMenu.setBorder(BorderFactory.createEmptyBorder());
		transactionPanel.add(scrollPaneMainMenu);
		
		tableList = new JTable();
		tableList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableList.setBackground(gray);
		tableList.setRowSelectionAllowed(false);
		tableList.setFillsViewportHeight(false);
		tableList.setCellSelectionEnabled(false);
		tableList.setFont(new Font("Courier New", Font.PLAIN, 11));
		tableList.getTableHeader().setResizingAllowed(false);
		tableList.getTableHeader().setReorderingAllowed(false);
		tableList.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		String[] convertedListColumns = {"No.", "Item Names", "Price"};
		tableList.setModel(new DefaultTableModel(page2Load(0), convertedListColumns)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		scrollPaneMainMenu.setViewportView(tableList);
		
		JLabel labelEnterItemNum = new JLabel("Enter Item No.");
		labelEnterItemNum.setFont(new Font("Courier New", Font.PLAIN, 14));
		labelEnterItemNum.setBounds(20, 240, 142, 28);
		transactionPanel.add(labelEnterItemNum);
		
		textFieldItemNum = new JTextField();
		textFieldItemNum.setFont(new Font("Courier New", Font.PLAIN, 12));
		textFieldItemNum.setBounds(20, 267, 189, 28);
		transactionPanel.add(textFieldItemNum);
		textFieldItemNum.setColumns(10);
		
		btnAddCart = new JButton("Add to Cart");
		btnAddCart.addActionListener(this);
		btnAddCart.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnAddCart.setBounds(277, 267, 142, 55);
		transactionPanel.add(btnAddCart);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(this);
		btnCheckout.setFont(new Font("Courier New", Font.PLAIN, 14));
		btnCheckout.setBounds(277, 350, 142, 55);
		transactionPanel.add(btnCheckout);
		
		JLabel labelItemQuantity = new JLabel("Enter Item Quantity");
		labelItemQuantity.setFont(new Font("Courier New", Font.PLAIN, 14));
		labelItemQuantity.setBounds(20, 295, 161, 28);
		transactionPanel.add(labelItemQuantity);
		
		textFieldItemQuantity = new JTextField();
		textFieldItemQuantity.setFont(new Font("Courier New", Font.PLAIN, 12));
		textFieldItemQuantity.setColumns(10);
		textFieldItemQuantity.setBounds(20, 322, 189, 28);
		transactionPanel.add(textFieldItemQuantity);
		
		lblErrorTransac = new JLabel("");
		lblErrorTransac.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblErrorTransac.setBounds(20, 412, 399, 14);
		transactionPanel.add(lblErrorTransac);
		
		JLabel lblNewLabel = new JLabel("ABC Bakery Menu");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(129, 11, 156, 28);
		transactionPanel.add(lblNewLabel);
		
		JLabel labelPayment = new JLabel("Enter Payment");
		labelPayment.setFont(new Font("Courier New", Font.PLAIN, 14));
		labelPayment.setBounds(20, 350, 161, 28);
		transactionPanel.add(labelPayment);
		
		textFieldPayment = new JTextField();
		textFieldPayment.setFont(new Font("Courier New", Font.PLAIN, 12));
		textFieldPayment.setColumns(10);
		textFieldPayment.setBounds(20, 377, 189, 28);
		transactionPanel.add(textFieldPayment);
		
		JPanel summaryPanel = new JPanel();
		summaryPanel.setBackground(bg);
		mainPanel.add(summaryPanel, "summary");
		summaryPanel.setLayout(null);
		
		JScrollPane scrollPaneSummary1 = new JScrollPane();
		scrollPaneSummary1.setFont(new Font("Courier New", Font.PLAIN, 11));
		scrollPaneSummary1.setBounds(10, 10, 409, 37);
		scrollPaneSummary1.setBorder(BorderFactory.createEmptyBorder());
		summaryPanel.add(scrollPaneSummary1);
		
		tableSummary1 = new JTable();
		tableSummary1.setFont(new Font("Courier New", Font.PLAIN, 11));
		tableSummary1.setBackground(gray);
		tableSummary1.setRowSelectionAllowed(false);
		tableSummary1.setCellSelectionEnabled(false);
		tableSummary1.getTableHeader().setResizingAllowed(false);
		tableSummary1.getTableHeader().setReorderingAllowed(false);
		tableSummary1.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		tableSummary1.setModel(new DefaultTableModel(page2Load(1), new String[] {"", ""})  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		scrollPaneSummary1.setViewportView(tableSummary1);
		
		JScrollPane scrollPaneSummary2 = new JScrollPane();
		scrollPaneSummary2.setFont(new Font("Courier New", Font.PLAIN, 11));
		scrollPaneSummary2.setBounds(10, 125, 409, 150);
		scrollPaneSummary2.setBackground(bg);
		scrollPaneSummary2.setBorder(BorderFactory.createEmptyBorder());
		summaryPanel.add(scrollPaneSummary2);
		
		tableSummary2 = new JTable();
		tableSummary2.setFont(new Font("Courier New", Font.PLAIN, 11));
		tableSummary2.setBackground(gray);
		tableSummary2.setRowSelectionAllowed(false);
		tableSummary2.setCellSelectionEnabled(false);
		tableSummary2.getTableHeader().setResizingAllowed(false);
		tableSummary2.getTableHeader().setReorderingAllowed(false);
		tableSummary2.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		String[] summary2Columns = {"No.", "Item Names", "Price", "Qty.", "Amount"};
		tableSummary2.setModel(new DefaultTableModel(page2Load(2), summary2Columns)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		scrollPaneSummary2.setViewportView(tableSummary2);
		
		JScrollPane scrollPaneSummary3 = new JScrollPane();
		scrollPaneSummary3.setBounds(10, 290, 409, 53);
		scrollPaneSummary3.setBorder(BorderFactory.createEmptyBorder());
		summaryPanel.add(scrollPaneSummary3);
		
		tableSummary3 = new JTable();
		tableSummary3.setFont(new Font("Courier New", Font.PLAIN, 11));
		tableSummary3.setBackground(gray);
		tableSummary3.setRowSelectionAllowed(false);
		tableSummary3.setCellSelectionEnabled(false);
		tableSummary3.getTableHeader().setResizingAllowed(false);
		tableSummary3.getTableHeader().setReorderingAllowed(false);
		tableSummary3.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		tableSummary3.setModel(new DefaultTableModel(page2Load(3), new String[] {"", ""})  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		scrollPaneSummary3.setViewportView(tableSummary3);
		
		btnDoneSummary = new JButton("Done");
		btnDoneSummary.addActionListener(this);
		btnDoneSummary.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnDoneSummary.setBounds(168, 401, 89, 23);
		summaryPanel.add(btnDoneSummary);
		
		JPanel stocksPanel = new JPanel();
		tabbedPane.addTab("Stocks", null, stocksPanel, "Manage Stocks and Items");
		stocksPanel.setBackground(bg);
		stocksPanel.setLayout(null);
		
		JScrollPane scrollPaneItem = new JScrollPane();
		scrollPaneItem.setFont(new Font("Courier New", Font.PLAIN, 11));
		scrollPaneItem.setBounds(10, 42, 409, 180);
		scrollPaneItem.setBorder(BorderFactory.createEmptyBorder());
		stocksPanel.add(scrollPaneItem);
		
		tableItem = new JTable();
		tableItem.setFont(new Font("Courier New", Font.PLAIN, 11));
		tableItem.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableItem.setBackground(gray);
		tableItem.setRowSelectionAllowed(false);
		tableItem.setCellSelectionEnabled(false);
		tableItem.getTableHeader().setResizingAllowed(false);
		tableItem.getTableHeader().setReorderingAllowed(false);
		tableItem.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		String[] tableItemColumns = {"No.", "Item Name"};
		tableItem.setModel(new DefaultTableModel(page2Load(0), tableItemColumns)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		scrollPaneItem.setViewportView(tableItem);
		
		JLabel lblCurrentItems = new JLabel("Current Items");
		lblCurrentItems.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblCurrentItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentItems.setBounds(156, 11, 113, 21);
		stocksPanel.add(lblCurrentItems);
		
		JLabel lblAddItems = new JLabel("Add Item:");
		lblAddItems.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddItems.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblAddItems.setBounds(13, 238, 113, 21);
		stocksPanel.add(lblAddItems);
		
		JLabel lblRemoveItems = new JLabel("Remove Item:");
		lblRemoveItems.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemoveItems.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblRemoveItems.setBounds(151, 238, 113, 21);
		stocksPanel.add(lblRemoveItems);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setToolTipText("Enter Item Name");
		textFieldItemName.setFont(new Font("Courier New", Font.PLAIN, 11));
		textFieldItemName.setBounds(13, 269, 120, 20);
		stocksPanel.add(textFieldItemName);
		textFieldItemName.setColumns(10);
		
		textFieldItemPrice = new JTextField();
		textFieldItemPrice.setToolTipText("Enter Item Price");
		textFieldItemPrice.setFont(new Font("Courier New", Font.PLAIN, 11));
		textFieldItemPrice.setColumns(10);
		textFieldItemPrice.setBounds(13, 315, 120, 20);
		stocksPanel.add(textFieldItemPrice);
		
		textFieldItemStock = new JTextField();
		textFieldItemStock.setToolTipText("Enter Item Stock");
		textFieldItemStock.setFont(new Font("Courier New", Font.PLAIN, 11));
		textFieldItemStock.setColumns(10);
		textFieldItemStock.setBounds(13, 361, 120, 20);
		stocksPanel.add(textFieldItemStock);
		
		JLabel lblAddStock = new JLabel("Add Stock:");
		lblAddStock.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddStock.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblAddStock.setBounds(289, 238, 113, 21);
		stocksPanel.add(lblAddStock);
		
		textFieldRemoveItem = new JTextField();
		textFieldRemoveItem.setToolTipText("Enter Item Number");
		textFieldRemoveItem.setFont(new Font("Courier New", Font.PLAIN, 11));
		textFieldRemoveItem.setColumns(10);
		textFieldRemoveItem.setBounds(151, 269, 120, 20);
		stocksPanel.add(textFieldRemoveItem);
		
		textFieldAddStockItemNum = new JTextField();
		textFieldAddStockItemNum.setToolTipText("Enter Item Number");
		textFieldAddStockItemNum.setFont(new Font("Courier New", Font.PLAIN, 11));
		textFieldAddStockItemNum.setColumns(10);
		textFieldAddStockItemNum.setBounds(289, 269, 120, 20);
		stocksPanel.add(textFieldAddStockItemNum);
		
		textFieldAddStock = new JTextField();
		textFieldAddStock.setToolTipText("Enter Stocks to Add");
		textFieldAddStock.setFont(new Font("Courier New", Font.PLAIN, 11));
		textFieldAddStock.setColumns(10);
		textFieldAddStock.setBounds(289, 315, 120, 20);
		stocksPanel.add(textFieldAddStock);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(this);
		btnAddItem.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnAddItem.setBounds(13, 395, 120, 23);
		stocksPanel.add(btnAddItem);
		
		btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.addActionListener(this);
		btnRemoveItem.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnRemoveItem.setBounds(151, 395, 120, 23);
		stocksPanel.add(btnRemoveItem);
		
		btnAddStock = new JButton("Add Stock");
		btnAddStock.addActionListener(this);
		btnAddStock.setFont(new Font("Courier New", Font.PLAIN, 11));
		btnAddStock.setBounds(289, 395, 120, 23);
		stocksPanel.add(btnAddStock);
		
		lblErrorStock = new JLabel("");
		lblErrorStock.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblErrorStock.setBounds(156, 367, 246, 14);
		stocksPanel.add(lblErrorStock);
		
		JPanel reportPanel = new JPanel();
		reportPanel.setBackground(bg);
		tabbedPane.addTab("Report", null, reportPanel, "Display Business Reports");
		reportPanel.setLayout(null);
		
		JScrollPane scrollPaneStocks = new JScrollPane();
		scrollPaneStocks.setBounds(10, 52, 409, 180);
		scrollPaneStocks.setBorder(BorderFactory.createEmptyBorder());
		reportPanel.add(scrollPaneStocks);
		
		tableStocks = new JTable();
		tableStocks.setFont(new Font("Courier New", Font.PLAIN, 11));
		tableStocks.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableStocks.setBackground(gray);
		tableStocks.setRowSelectionAllowed(false);
		tableStocks.setCellSelectionEnabled(false);
		tableStocks.getTableHeader().setResizingAllowed(false);
		tableStocks.getTableHeader().setReorderingAllowed(false);
		tableStocks.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		String[] stocksColumn = {"No.", "Item Name", "Stocks"};
		tableStocks.setModel(new DefaultTableModel(page4Load(0), stocksColumn)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		scrollPaneStocks.setViewportView(tableStocks);
		
		JScrollPane scrollPaneSalesReport = new JScrollPane();
		scrollPaneSalesReport.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneSalesReport.setBounds(10, 309, 409, 53);
		reportPanel.add(scrollPaneSalesReport);
		
		tableSalesReport = new JTable();
		tableSalesReport.setFont(new Font("Courier New", Font.PLAIN, 11));
		tableSalesReport.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableSalesReport.setBackground(gray);
		tableSalesReport.setRowSelectionAllowed(false);
		tableSalesReport.setCellSelectionEnabled(false);
		tableSalesReport.getTableHeader().setResizingAllowed(false);
		tableSalesReport.getTableHeader().setReorderingAllowed(false);
		tableSalesReport.getTableHeader().setFont(new Font("Courier New", Font.PLAIN, 11));
		tableSalesReport.setModel(new DefaultTableModel(page4Load(1), new String[] {"", ""})  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		scrollPaneSalesReport.setViewportView(tableSalesReport);
		
		JLabel lblShowStocks = new JLabel("Stocks");
		lblShowStocks.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblShowStocks.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowStocks.setBounds(173, 25, 78, 21);
		reportPanel.add(lblShowStocks);
		
		JLabel lblSalesReport = new JLabel("Sales Report");
		lblSalesReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesReport.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblSalesReport.setBounds(163, 282, 103, 21);
		reportPanel.add(lblSalesReport);
		
		lblGrpName = new JLabel("Group V | BSCS - 1A");
		lblGrpName.setFont(new Font("Courier New", Font.PLAIN, 11));
		lblGrpName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrpName.setBounds(143, 408, 142, 14);
		reportPanel.add(lblGrpName);
		
		CaseStudyG51ACompute.dir.mkdirs();
		
		fileChoose = new JFileChooser(CaseStudyG51ACompute.dir);
		fileChoose.setFileFilter(new FileNameExtensionFilter("Table Data File", "tabledata", "TABLEDATA"));
		
	}
	
	private String[][] page2Load(int index) {
		String[][] ret = null;
		
		if (index == 0) {
			ret = CaseStudyG51ACompute.convert2DArrayItems();
		} else if (index == 1) {
			ret = CaseStudyG51ACompute.convertOrderSummary1();
		} else if (index == 2) {
			ret = CaseStudyG51ACompute.convertOrderSummary2();
		} else if (index == 3) {
			ret = CaseStudyG51ACompute.convertOrderSummary3();
		}
		
		return ret;
	}
	
	private String[][] page4Load(int index) {
		String[][] ret = null;
		
		if (index == 0) {
			ret = CaseStudyG51ACompute.convert2DArrayStocks();
		} else if (index == 1) {
			ret = CaseStudyG51ACompute.convertReport();
		}
		
		return ret;
	}
	
	private void tableReload() {
		
		// table list
		String[] convertedListColumns = {"No.", "Item Names", "Price"};
		tableList.setModel(new DefaultTableModel(page2Load(0), convertedListColumns)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		// table summary 1
		tableSummary1.setModel(new DefaultTableModel(page2Load(1), new String[] {"", ""})  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		// table summary 2
		String[] summary2Columns = {"No.", "Item Names", "Price", "Qty.", "Amount"};
		tableSummary2.setModel(new DefaultTableModel(page2Load(2), summary2Columns)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		// table summary 3
		tableSummary3.setModel(new DefaultTableModel(page2Load(3), new String[] {"", ""})  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		//table item
		String[] tableItemColumns = {"No.", "Item Name"};
		tableItem.setModel(new DefaultTableModel(page2Load(0), tableItemColumns)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		// table stocks
		String[] stocksColumn = {"No.", "Item Name", "Stocks"};
		tableStocks.setModel(new DefaultTableModel(page4Load(0), stocksColumn)  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
		// table sales report
		tableSalesReport.setModel(new DefaultTableModel(page4Load(1), new String[] {"", ""})  {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});
		
	}
	
	private String tempTableNumCheck(String input) {
		
		boolean check = CaseStudyG51ACompute.intCheck(input);
		int tempInt;
		
		if (check) {
			
			tempInt = Integer.parseInt(input);
			
			if (itemInBounds(tempInt, 1, 50)) {
				tempTableCreateArr(tempInt);
				return "";
			} else {
				return "Input must not be greater than 50 or less than 1!";
			}
			
		} else {
			return "Input is not an integer! Please try again.";
		}
		
	}
	
	private void tempTableCreateArr(int input) {
		
		String[][] tempTableArr = new String[input][3];
		
		for (int x = 0; x < tempTableArr.length; x++) {
			
			for (int y = 0; y < 3; y++) {
				tempTableArr[x][y] = "";
			}
			
		}
		
		tempTableLoad(tempTableArr);
	}
	
	private void tempTableLoad(String[][] inputTempArr) {
		
		String[] tempColumns = {"Name (NOT Empty)", "Price (Any Number)", "Stock (Whole num)"};
		tempTable.setModel(new DefaultTableModel(inputTempArr, tempColumns));
		tempTableLoaded = true;
		
	}
	
	private void getTempTableData() {
		
		String[][] tempTableData = new String[tempTable.getModel().getRowCount()][tempTable.getModel().getColumnCount()];
		
		for (int x = 0; x < tempTableData.length; x++) {
			
			for (int y = 0; y < tempTableData[x].length; y++) {
				tempTableData[x][y] = tempTable.getModel().getValueAt(x, y).toString();
			}
			
		}
		
		checkTempTableData(tempTableData);
	}
	
	private void checkTempTableData(String[][] tempTableData) {
				
		lblTempTableState.setText("");
		// error counter
		int err = 0;
		double tempDoub = -1;
		int tempInt = -1;
		
		for (int x = 0; x < tempTableData.length; x++) {
			
			// name check so that all items have names
			boolean check1 = (tempTableData[x][0].equals(""));
			// number check for price, double literals are not included as valid answers
			boolean check2 = ((!CaseStudyG51ACompute.doubleCheck(tempTableData[x][1])) || tempTableData[x][1].endsWith("F") || tempTableData[x][1].endsWith("f") || tempTableData[x][1].endsWith("D") || tempTableData[x][1].endsWith("d"));
			// integer check for stock
			boolean check3 = (!CaseStudyG51ACompute.intCheck(tempTableData[x][2]));
			
			// data conversion
			if (!check2) {
				tempDoub = Double.parseDouble(tempTableData[x][1]);
			}
			
			if (!check3) {
				tempInt = Integer.parseInt(tempTableData[x][2]);
			}
			
			
			// bound check
			boolean check4 = (!itemInBounds(tempDoub, 0, 9999));
			boolean check5 = (!itemInBounds(tempInt, 0, 999));
			
			// checks whether columns 1, 2, and 3 are strings, doubles, and integers respectively
			// limitations: doesn't tell user where error is.
			if (check1) {
				err++;
			}

			if (check2) {
				err++;
				tempTable.getModel().setValueAt("", x, 1);
				
			}
			 
			if (check3) {
				err++;
				tempTable.getModel().setValueAt("", x, 2);
			}
			
			// bounds check if statement
			if (check4 && check2) {
				tempTable.getModel().setValueAt("", x, 1);
			} else if (check4 && !check2) {
				
				err++;
				tempTable.getModel().setValueAt("", x, 1);
				
			}
			
			if (check5 && check3) {
				tempTable.getModel().setValueAt("", x, 2);
			} else if (check5 && !check3) {
				
				err++;
				tempTable.getModel().setValueAt("", x, 2);
				
			}
			
		}
		
		if (err > 0) {
			lblTempTableState.setText(err + " errors found! Erroneous values have been cleared.");
		} else {
			
			lblTempTableState.setText("");
			lblFileOpen.setText("Custom File Successfuly Created!");
			CaseStudyG51ACompute.convertToList(tempTableData);
			fileOpen = true;
			tableReload();
			crd2.show(filePanel, "main");
			
		}
		
	}
	
	private void addToCart() {
		
		String numString = textFieldItemNum.getText();
		String quantString = textFieldItemQuantity.getText();
		
		int tempNum = -1;
		int tempQuant = -1;
		
		boolean checkNum = CaseStudyG51ACompute.intCheck(numString);
		boolean checkQuant = CaseStudyG51ACompute.intCheck(quantString);
		boolean isInt = false;
		boolean numOutOfBounds = true;
		boolean quantOutOfBounds = true;
		
		// integer check for inputs
		if (checkNum && checkQuant) {
			
			tempNum = Integer.parseInt(numString);
			tempQuant = Integer.parseInt(quantString);
			isInt = true;
			
		} else if (checkNum && !checkQuant) {
			
			lblErrorTransac.setText("Error! Quantity must be an integer.");
			textFieldItemQuantity.setText("");
			
		} else if (!checkNum && checkQuant) {

			lblErrorTransac.setText("Error! Number must be an integer.");
			textFieldItemNum.setText("");
			
		} else if (!checkNum && !checkQuant) {
			
			lblErrorTransac.setText("Error! Values must be an integer.");
			textFieldItemNum.setText("");
			textFieldItemQuantity.setText("");
			
		}
		
		// bounds check
		if (isInt) {
			
			// bound check for number
			if (tempNum < 1 || tempNum > CaseStudyG51ACompute.bread.size()) {
				
				lblErrorTransac.setText("Error! Item does not exist.");
				textFieldItemNum.setText("");
				
			} else {
				numOutOfBounds = false;
			}
			
		}
		
		// bound check for quantity
		if (isInt && !numOutOfBounds) {
			
			if (tempQuant < 1) {
				lblErrorTransac.setText("Error! You can't order less than 1 item.");
				textFieldItemQuantity.setText("");
			} else if (tempQuant > 50) {
				lblErrorTransac.setText("Error! Max orders is 50.");
				textFieldItemQuantity.setText("");
			} else if (CaseStudyG51ACompute.stock.get(tempNum - 1) - tempQuant < 0) {
				lblErrorTransac.setText("Error! Not enough stock.");
				textFieldItemQuantity.setText("");
			} else {
				quantOutOfBounds = false;
			}
						
		}
		
		// final part, passing values to compute method
		if (isInt && !numOutOfBounds && !quantOutOfBounds ) {
			
			CaseStudyG51ACompute.orderUI(tempNum, tempQuant);
			lblErrorTransac.setText("Item added successfully!");
			textFieldItemNum.setText("");
			textFieldItemQuantity.setText("");
			tableReload();
			
		}
		
	}
	
	private void checkout() {
		
		boolean doubCheck = CaseStudyG51ACompute.doubleCheck(textFieldPayment.getText());
		
		if (doubCheck) {
			
			double tempPay = Double.parseDouble(textFieldPayment.getText());
			
			if (tempPay - CaseStudyG51ACompute.total < 0) {
				
				lblErrorTransac.setText("Error! Not enough payment.");
				textFieldPayment.setText("");
				
			} else {
				
				CaseStudyG51ACompute.pay = tempPay;
				textFieldPayment.setText("");
				lblErrorTransac.setText("");
				CaseStudyG51ACompute.orderTotal++;
				orderInProgress = false;
				tableReload();
				crd.show(mainPanel, "summary");
				
			}
			
		} else {
			lblErrorTransac.setText("Payment must be a number.");
		}
		
	}
	
	private void addItem() {
		
		// basically same thing as number checking the temporary table, but without the for loop
		
		boolean canAdd = !(CaseStudyG51ACompute.bread.size() + 1 > 50);
		
		boolean check1 = (textFieldItemName.getText().equals(""));
		// number check for price, double literals are not included as valid answers
		boolean check2 = (!CaseStudyG51ACompute.doubleCheck(textFieldItemPrice.getText()) || textFieldItemName.getText().endsWith("F") || textFieldItemName.getText().endsWith("f") || textFieldItemName.getText().endsWith("D") || textFieldItemName.getText().endsWith("d"));
		// integer check for stock
		boolean check3 = (!CaseStudyG51ACompute.intCheck(textFieldItemStock.getText()));
		
		boolean typeCheck = !(check1 || check2 || check3);
		boolean boundsCheck = false;
		
		double tempDoub = -1;
		int tempInt = -1;
		
		if (!check2) {
			tempDoub = Double.parseDouble(textFieldItemPrice.getText());
		}
		
		if (!check3) {
			tempInt = Integer.parseInt(textFieldItemStock.getText());
		}
		
		// checks whether columns 1, 2, and 3 are strings, doubles, and integers respectively. also max size
		// limitations: can only show one error at a time.
		
		if (canAdd) {
			
			
			
			if (check1) {
				lblErrorStock.setText("Item name must not be empty.");
			}

			if (check2) {
				
				lblErrorStock.setText("Item price must be a number.");
				textFieldItemPrice.setText("");
				
			}
			 
			if (check3) {
				
				lblErrorStock.setText("Item stock must be an integer");
				textFieldItemStock.setText("");
				
			}
			
			
		} else {
			lblErrorStock.setText("Error! Item limit is 50.");
			textFieldItemName.setText("");
			textFieldItemPrice.setText("");
			textFieldItemStock.setText("");
		}
		
		// bounds check
		if (typeCheck && canAdd) {
			
			if (!itemInBounds(tempDoub, 0, 9999)) {
				
				lblErrorStock.setText("Error! Value out of bounds.");
				textFieldItemPrice.setText("");
				
			} else if (!itemInBounds(tempInt, 0, 999)) {
				
				lblErrorStock.setText("Error! Value out of bounds.");
				textFieldItemStock.setText("");
				
			} else {
				boundsCheck = true;
			}
			
		}
		
		// adding to compute method
		if (typeCheck && canAdd && boundsCheck) {
			CaseStudyG51ACompute.addItem(textFieldItemName.getText(), tempDoub, tempInt);
			textFieldItemName.setText("");
			textFieldItemPrice.setText("");
			textFieldItemStock.setText("");
			tableReload();
			lblErrorStock.setText("Item successfully added!");
		}
		
	}
	
	private void removeItem() {
		
		//check if input is integer
		boolean check = CaseStudyG51ACompute.intCheck(textFieldRemoveItem.getText());
		
		if (check) {
			
			int tempInt = Integer.parseInt(textFieldRemoveItem.getText());
			
			if (tempInt > CaseStudyG51ACompute.bread.size() || tempInt < 1) {
				
				lblErrorStock.setText("Input out of bounds!");
				textFieldRemoveItem.setText("");
				
			} else {
				
				CaseStudyG51ACompute.removeItem(tempInt);
				lblErrorStock.setText("Item successfully removed!");
				textFieldRemoveItem.setText("");
				tableReload();
				
				
			}
			
		} else {
			
			lblErrorStock.setText("Input must be a number!");
			textFieldRemoveItem.setText("");
			
		}
		
	}
	
	private void addStock() {
		
		boolean check = CaseStudyG51ACompute.intCheck(textFieldAddStockItemNum.getText());
		boolean check2 = CaseStudyG51ACompute.intCheck(textFieldAddStock.getText());
		int tempNum = -1;
		int tempStock = -1;
		
		// check integer for item number
		if (check) {
			tempNum = Integer.parseInt(textFieldAddStockItemNum.getText());
		} else {
			
			lblErrorStock.setText("Error! Input must be an integer.");
			textFieldAddStockItemNum.setText("");
			
		}
		
		// check integer for item stock
		if (check2) {
			tempStock = Integer.parseInt(textFieldAddStock.getText());
		} else {
			
			lblErrorStock.setText("Error! Input must be an integer.");
			textFieldAddStock.setText("");
			
		}
		
		// check bounds
		
		if (check && check2) {
			
			if (tempNum > CaseStudyG51ACompute.bread.size() || tempNum < 1) {
				
				lblErrorStock.setText("Error! Item does not exist.");
				textFieldAddStockItemNum.setText("");
				
			} else {
				
				if (tempStock < 0) {
					
					lblErrorStock.setText("Error! Negative stocks can't be added.");
					textFieldAddStock.setText("");
					
				} else if (tempStock + CaseStudyG51ACompute.stock.get(tempNum - 1) > 999) {
					
					lblErrorStock.setText("Error! 999 stocks are the maximum.");
					textFieldAddStock.setText("");
					
				} else {
					
					CaseStudyG51ACompute.addStock(tempNum, tempStock);
					lblErrorStock.setText("Stocks successfully added!");
					textFieldAddStock.setText("");
					textFieldAddStockItemNum.setText("");
					tableReload();
					
				}
				
			}
			
		}
		
		
		
	}
	
	private boolean itemInBounds(double val, int min, int max) {
		
		if (val > max) {
			return false;
		} else if (val < min) {
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		
		// file pane page 1
		if (click.getSource() == btnDefaultFile) {
			
			CaseStudyG51ACompute.defaultFile();
			lblFileOpen.setText("File Successfully Created!");
			fileOpen = true;
			tableReload();
			
		} else if (click.getSource() == btnCustomFile) {
			crd2.show(filePanel, "custom file");
		} else if (click.getSource() == btnOpenFile) {
			
			if (fileChoose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				String filePath = fileChoose.getSelectedFile().getAbsolutePath();
				lblFileOpen.setText(CaseStudyG51ACompute.openFile(CaseStudyG51ACompute.endsWith(filePath)));
				tableReload();
				
			}
			
		} else if (click.getSource() == btnSaveFile) {
			
			if (fileOpen) {
				
				if (fileChoose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					
					String filePath = fileChoose.getSelectedFile().getAbsolutePath();
					lblFileOpen.setText(CaseStudyG51ACompute.saveFile(CaseStudyG51ACompute.endsWith(filePath)));
					tableReload();
					
				}
				
			} else {
				lblFileOpen.setText("No File Open! Saving not allowed.");
			}
			
		} else if (click.getSource() == btnDeleteFile) {
			
			if (fileChoose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				String filePath = fileChoose.getSelectedFile().getAbsolutePath();
				lblFileOpen.setText(CaseStudyG51ACompute.deleteFile(CaseStudyG51ACompute.endsWith(filePath)));
				
			}
			
		}
		
		// file pane page 2
		if (click.getSource() == btnCreateTempTable) {
			lblTempTableState.setText(tempTableNumCheck(textFieldTableCreate.getText()));
		} else if (click.getSource() == btnTempTableDone) {
			
			// check if there is temporary table, otherwise button is disabled.
			if (tempTableLoaded) {
				getTempTableData();
			} else {
				lblTempTableState.setText("No Table Created!");
			}
			
		}
		
		// main page 1
		if (click.getSource() == btnNewTransac) {
			
			if (textFieldInputName.getText().equals("")) {
				lblErrName.setText("Name must not be empty!");
			} else if (!fileOpen) {
				lblErrName.setText("No File Open!");
			} else {
				
				CaseStudyG51ACompute.name = textFieldInputName.getText();
				orderInProgress = true;
				textFieldInputName.setText("");
				lblErrName.setText("");
				crd.show(mainPanel, "transac");
				
			}
			
		}
		
		// main page 2, inaccessible if file open is false
		if (click.getSource() == btnAddCart) {
			addToCart();
		} else if (click.getSource() == btnCheckout) {
			
			if (CaseStudyG51ACompute.itemOrdered.size() == 0) {
				lblErrorTransac.setText("You have not put anything in your cart!");
			} else {
				checkout();
			}
		}
		
		// main page 3, inaccessible if file open is false
		if (click.getSource() == btnDoneSummary) {
			
			CaseStudyG51ACompute.itemOrdered.clear();
			CaseStudyG51ACompute.quantityOrdered.clear();
			CaseStudyG51ACompute.total = 0;
			crd.show(mainPanel, "menu");
			
		}
		
		// stocks page, buttons disabled if file open is false
		if (click.getSource() == btnAddItem) {
			
			if (fileOpen) {
				
				if (orderInProgress) {
					lblErrorStock.setText("Can't Edit! Order in Progress!");
				} else {
					addItem();
				}
				
			} else {
				lblErrorStock.setText("No File Open!");
			}
			
		} else if (click.getSource() == btnRemoveItem) {
			
			if (fileOpen) {
				
				if (orderInProgress) {
					lblErrorStock.setText("Can't Edit! Order in Progress!");
				} else {
					removeItem();
				}
				
			} else {
				lblErrorStock.setText("No File Open!");
			}
			
		} else if (click.getSource() == btnAddStock) {
			
			if (fileOpen) {
				
				if (orderInProgress) {
					lblErrorStock.setText("Can't Edit! Order in Progress!");
				} else {
					addStock();
				}
				
			} else {
				lblErrorStock.setText("No File Open!");
			}
			
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		// listen change is false at the start to prevent statements
		// below from running when the program loads. this is to prevent
		// exceptions since the labels are not yet initialized at the start. 
		
		if (listenChange) {
			
			// clears text when switching tabs
			lblFileOpen.setText("");
			lblTempTableState.setText("");
			lblErrName.setText("");
			lblErrorTransac.setText("");
			lblErrorStock.setText("");
			
		} else {
			listenChange = true;
		}
		
	}
	
}