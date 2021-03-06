package sonar.fluxnetworks.client.mui;

public class WirelessCharging {/*extends Module {

    protected WirelessCharging() {
        addWireless(EnumChargingTypes.ARMOR_SLOT, 24, 32, 0, 80, 52, 16);
        addWireless(EnumChargingTypes.BAUBLES, 100, 32, 0, 80, 52, 16);
        addWireless(EnumChargingTypes.INVENTORY, 32, 57, 0, 0, 112, 40);
        addWireless(EnumChargingTypes.HOT_BAR, 32, 106, 112, 0, 112, 16);
        addWireless(EnumChargingTypes.LEFT_HAND, 24, 131, 52, 80, 16, 16);
        addWireless(EnumChargingTypes.RIGHT_HAND, 136, 131, 52, 80, 16, 16);
        addWidget(new SlidingToggleButton.Builder(0x8006c909, 0x40808080, 4)
                .setLocator(new Locator(47, 73))
                .build(this)
                .buildCallback(EnumChargingTypes.ENABLE_WIRELESS.isActivated(NavigationHome.network),
                        b -> changeWireless(EnumChargingTypes.ENABLE_WIRELESS)));
    }

    private void addWireless(@Nonnull EnumChargingTypes type, float x, float y, float u, float v, float w, float h) {
        Icon icon = new Icon(ScreenUtils.INVENTORY, u / 256f, v / 256f, (u + w) / 256f, (v + h) / 256f, false);
        Widget.Builder builder = new Widget.Builder().setWidth(w).setHeight(h).setLocator(new Locator(x - 88, y - 83));
        addWidget(new WirelessSlot(this, builder, icon, type));
    }

    private void changeWireless(@Nonnull EnumChargingTypes type) {
        int setting = NavigationHome.network.getSetting(NetworkSettings.NETWORK_WIRELESS);

        if (type.isActivated(setting)) {
            setting &= ~(1 << type.ordinal());
        } else {
            setting |= 1 << type.ordinal();
        }

        PacketHandler.CHANNEL.sendToServer(
                new GeneralPacket(GeneralPacketEnum.CHANGE_WIRELESS, GeneralPacketHandler.getChangeWirelessPacket(
                        NavigationHome.network.getNetworkID(), setting)));
    }

    private class WirelessSlot extends Widget {

        private final Icon icon;
        private final String text;
        private final EnumChargingTypes type;

        public WirelessSlot(IHost host, @Nonnull Builder builder, @Nonnull Icon icon, @Nonnull EnumChargingTypes type) {
            super(host, builder);
            this.icon = icon;
            this.text = type.getTranslatedName();
            this.type = type;
        }

        @Override
        protected void onDraw(@Nonnull Canvas canvas, float time) {
            int color = NavigationHome.network.getSetting(NetworkSettings.NETWORK_COLOR);
            float r = Color3i.getRedFrom(color);
            float g = Color3i.getGreenFrom(color);
            float b = Color3i.getBlueFrom(color);
            if (type.isActivated(NavigationHome.network)) {
                canvas.setRGBA(r, g, b, 1);
            } else {
                canvas.setRGBA(r * 0.7f, g * 0.7f, b * 0.7f, 0.7f);
            }
            canvas.drawIcon(icon, x1, y1, x2, y2);
            if (isMouseHovered()) {
                canvas.setTextAlign(TextAlign.CENTER);
                canvas.resetColor();
                canvas.drawText(text, x1 + width / 2, y1 - 9);
            }
        }

        @Override
        protected boolean onMouseLeftClick(double mouseX, double mouseY) {
            changeWireless(type);
            return true;
        }
    }*/
}
