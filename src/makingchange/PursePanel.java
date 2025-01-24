package makingchange;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        this.purse = new Purse();
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (purse == null || purse.getValue() == 0) {
            g.drawString("Empty Purse!", 10, 20);
            return;
        }

        int x = 10;
        int y = 20;

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            ImageIcon icon = new ImageIcon(denom.img());
            Image img = icon.getImage();
            g.drawImage(img, x, y, 50, 50, this);

            g.drawString(count + " x " + denom.name(), x + 60, y + 30);
            y += 60;
        }
    }
}
