package dev.hoot.api.packets;

import dev.hoot.api.game.Game;
import net.runelite.api.Client;
import net.runelite.api.TileItem;
import net.runelite.api.packets.ClientPacket;
import net.runelite.api.packets.PacketBufferNode;

import java.util.List;

public class GroundItemPackets
{
	public static void groundItemFirstOption(TileItem item, boolean ctrlDown)
	{
		GroundItemPackets.queueGroundItemAction1Packet(item.getId(), item.getWorldLocation().getX(), item.getWorldLocation().getY(), ctrlDown);
	}

	public static void groundItemSecondOption(TileItem item, boolean ctrlDown)
	{
		GroundItemPackets.queueGroundItemAction2Packet(item.getId(), item.getWorldLocation().getX(), item.getWorldLocation().getY(), ctrlDown);
	}

	public static void groundItemThirdOption(TileItem item, boolean ctrlDown)
	{
		GroundItemPackets.queueGroundItemAction3Packet(item.getId(), item.getWorldLocation().getX(), item.getWorldLocation().getY(), ctrlDown);
	}

	public static void groundItemFourthOption(TileItem item, boolean ctrlDown)
	{
		GroundItemPackets.queueGroundItemAction4Packet(item.getId(), item.getWorldLocation().getX(), item.getWorldLocation().getY(), ctrlDown);
	}

	public static void groundItemFifthOption(TileItem item, boolean ctrlDown)
	{
		GroundItemPackets.queueGroundItemAction5Packet(item.getId(), item.getWorldLocation().getX(), item.getWorldLocation().getY(), ctrlDown);
	}

	public static void groundItemAction(TileItem item, String action, boolean ctrlDown)
	{
		List<String> actions = item.getActions();
		int index = actions.indexOf(action);
		switch (index)
		{
			case 0:
				GroundItemPackets.groundItemFirstOption(item, ctrlDown);
				break;
			case 1:
				GroundItemPackets.groundItemSecondOption(item, ctrlDown);
				break;
			case 2:
				GroundItemPackets.groundItemThirdOption(item, ctrlDown);
				break;
			case 3:
				GroundItemPackets.groundItemFourthOption(item, ctrlDown);
				break;
			case 4:
				GroundItemPackets.groundItemFifthOption(item, ctrlDown);
				break;
		}
	}

	public static void queueItemUseOnGroundObjectPacket(int groundItemId, int worldPointX, int worldPointY, int itemSlot, int itemId, int itemWidgetId, boolean ctrlDown)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPOBJU(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShort(itemId);
		packetBufferNode.getPacketBuffer().writeShort(itemSlot);
		packetBufferNode.getPacketBuffer().writeShort(worldPointY);
		packetBufferNode.getPacketBuffer().writeShortAddLE(groundItemId);
		packetBufferNode.getPacketBuffer().writeIntIME(itemWidgetId);
		packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShortAddLE(worldPointX);
		client.getPacketWriter().queuePacket(packetBufferNode);
	}

	public static void queueSpellOnGroundObjectPacket(int groundItemId, int worldPointX, int worldPointY, int spellWidgetId, boolean ctrlDown)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPOBJT(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortLE(worldPointY);
		packetBufferNode.getPacketBuffer().writeShort(-1);
		packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeInt(spellWidgetId);
		packetBufferNode.getPacketBuffer().writeShort(worldPointX);
		packetBufferNode.getPacketBuffer().writeShortAddLE(groundItemId);
		packetBufferNode.getPacketBuffer().writeShort(-1);
		client.getPacketWriter().queuePacket(packetBufferNode);
	}

	public static void queueGroundItemAction1Packet(int groundItemId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPOBJ1(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortLE(worldPointX);
		packetBufferNode.getPacketBuffer().writeShortAdd(groundItemId);
		packetBufferNode.getPacketBuffer().writeShortAdd(worldPointY);
		packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);
		client.getPacketWriter().queuePacket(packetBufferNode);
	}

	public static void queueGroundItemAction2Packet(int groundItemId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPOBJ2(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeByteSub(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShortAddLE(worldPointY);
		packetBufferNode.getPacketBuffer().writeShortAddLE(groundItemId);
		packetBufferNode.getPacketBuffer().writeShortAdd(worldPointX);
		client.getPacketWriter().queuePacket(packetBufferNode);
	}

	public static void queueGroundItemAction3Packet(int groundItemId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPOBJ3(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortAddLE(worldPointX);
		packetBufferNode.getPacketBuffer().writeShort(groundItemId);
		packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShortAdd(worldPointY);
		client.getPacketWriter().queuePacket(packetBufferNode);
	}

	public static void queueGroundItemAction4Packet(int groundItemId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPOBJ4(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortAdd(worldPointY);
		packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShort(groundItemId);
		packetBufferNode.getPacketBuffer().writeShortLE(worldPointX);
		client.getPacketWriter().queuePacket(packetBufferNode);
	}

	public static void queueGroundItemAction5Packet(int groundItemId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPOBJ5(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortLE(worldPointX);
		packetBufferNode.getPacketBuffer().writeShortAdd(worldPointY);
		packetBufferNode.getPacketBuffer().writeShortLE(groundItemId);
		packetBufferNode.getPacketBuffer().writeByteSub(ctrlDown ? 1 : 0);
		client.getPacketWriter().queuePacket(packetBufferNode);
	}
}