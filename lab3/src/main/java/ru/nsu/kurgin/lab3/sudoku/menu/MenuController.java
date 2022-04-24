package ru.nsu.kurgin.lab3.sudoku.menu;

public class MenuController implements InterfaceMenuController{
    private MenuModel menuModel;

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @Override
    public void clickInNewGame() {
        menuModel.gameLoad();
    }

    @Override
    public void clickInStatistics() {
        menuModel.statisticsLoad();
    }

    @Override
    public void clickInExitGame() {
        menuModel.exitGame();
    }
}
